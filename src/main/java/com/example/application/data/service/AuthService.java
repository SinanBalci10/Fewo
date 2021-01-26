package com.example.application.data.service;

import com.example.application.data.entity.Role;
import com.example.application.data.entity.User;
import com.example.application.data.service.repository.UserRepository;
import com.example.application.views.dashboard.DashboardView;
import com.example.application.views.eigeneFerienwohnung.EigeneFerienwohnungView;
import com.example.application.views.kontoVerwalten.KontoVerwaltenView;
import com.example.application.views.mietverlauf.MietverlaufView;
import com.example.application.views.nachrichtSenden.NachrichtSendenView;
import com.example.application.views.postfach.PostfachView;
import com.example.application.views.stornieren.StornierenView;
import com.example.application.views.admin.AdminView;
import com.example.application.views.home.HomeView;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//controller
@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public class AuthException extends Exception {

    }

    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    //void suche() wohnungsrepo


    public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.getByUsername(username);
        if (user != null && user.checkPassword(password) && user.isActive()) {
            VaadinSession.getCurrent().setAttribute(User.class, user);
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    // im menu links erscheinen lassen
    // wenn es nicht hier mit drin steht, aber in logoutView zu login navigiert, dann kannst du im url namen manuel ändern in "..8080/login"
    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("dashboard", "Dashboard", DashboardView.class));
            //routes.add(new AuthorizedRoute("musterhaus", "Musterhaus", MusterhausView.class));
            //routes.add(new AuthorizedRoute("beispielhaus", "Beispielhaus", BeispielhausView.class));
            routes.add(new AuthorizedRoute("mietverlauf", "Mietverlauf", MietverlaufView.class));
            routes.add(new AuthorizedRoute("eigeneFerienwohnung", "Eigene Ferienwohnung", EigeneFerienwohnungView.class));
            routes.add(new AuthorizedRoute("kontoVerwalten", "Konto Verwalten", KontoVerwaltenView.class));
            routes.add(new AuthorizedRoute("postfach", "Postfach", PostfachView.class));
            routes.add(new AuthorizedRoute("nachrichtSenden", "Nachricht Senden", NachrichtSendenView.class));
            routes.add(new AuthorizedRoute("stornieren", "Stornieren", StornierenView.class));
          // routes.add(new AuthorizedRoute("abmelden", "Abmelden", LogoutView.class));
          //  routes.add(new AuthorizedRoute("beispielhaus", "Beispielhaus", Beispielhaus.class));

        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("admin", "Admin", AdminView.class));
            routes.add(new AuthorizedRoute("dashboard", "Dashboard", DashboardView.class));
            routes.add(new AuthorizedRoute("mietverlauf", "Mietverlauf", MietverlaufView.class));
            routes.add(new AuthorizedRoute("eigeneFerienwohnung", "Eigene Ferienwohnungen", EigeneFerienwohnungView.class));
            routes.add(new AuthorizedRoute("kontoVerwalten", "Konto verwalten", KontoVerwaltenView.class));
            routes.add(new AuthorizedRoute("postfach", "Postfach", PostfachView.class));
            routes.add(new AuthorizedRoute("nachrichtSenden", "Nachricht senden", NachrichtSendenView.class));
            routes.add(new AuthorizedRoute("stornieren", "Stornieren", StornierenView.class));
           // routes.add(new AuthorizedRoute("abmelden", "Abmelden", LogoutView.class))
             //routes.add(new AuthorizedRoute("beispielhaus", "Beispielhaus", Beispielhaus.class));
        }

        return routes;
    }

    //registrieren mit dem link
    public void register(String username, String password) {
        User user = userRepository.save(new User(username, password, Role.USER));
        System.out.println("http://localhost:8080/activate?code=" + user.getActivationCode());
    }

    //registrierung aktivierung
    public void activate(String activationCode) throws AuthException {
        User user = userRepository.getByActivationCode(activationCode);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        } else {
            throw new AuthException();
        }
    }
}