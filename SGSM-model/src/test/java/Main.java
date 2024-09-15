
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ro.uaic.feaa.psi.sgsm.model.servlet.InvoiceServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create a basic Jetty server object that will listen on port 8080.
        Server server = new Server(8080);

        // The ServletContextHandler is a Jetty-specific handler that wraps
        // a standard Servlet context.
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Add the servlet to the context
        context.addServlet(new ServletHolder(new InvoiceServlet()), "/api/*");

        // Serve static content from the webapp directory
        context.setResourceBase("C:\\Users\\macov\\OneDrive\\Desktop\\Proiect1.SfaiterAgnesBesleagaIsabela\\SGSM-model\\src\\main\\resources\\webapp");
        context.addServlet(DefaultServlet.class, "/");

        // Set the context handler
        server.setHandler(context);

        // Start the server
        server.start();
        server.join();
    }
}
