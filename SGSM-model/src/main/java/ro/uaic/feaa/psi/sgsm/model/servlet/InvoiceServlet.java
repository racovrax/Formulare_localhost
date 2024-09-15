package ro.uaic.feaa.psi.sgsm.model.servlet;

import ro.uaic.feaa.psi.sgsm.model.entities.Clienti;
import ro.uaic.feaa.psi.sgsm.model.entities.Facturi;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/*")
public class InvoiceServlet extends HttpServlet {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGSMPersistenceUnit");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager em = emf.createEntityManager();
        String path = req.getPathInfo();

        if (path.equals("/vehicule")) {
            List<Vehicule> vehiculeList = em.createQuery("SELECT v FROM Vehicule v", Vehicule.class).getResultList();
            em.close();

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.println("[");
            for (int i = 0; i < vehiculeList.size(); i++) {
                Vehicule vehicul = vehiculeList.get(i);
                out.println("{\"id\": \"" + vehicul.getId() + "\", \"name\": \"" + vehicul.getNume() + "\", \"price\": \"" + vehicul.getPreturi() + "\", \"details\": \"" + vehicul.getDetalii() + "\"}");
                if (i < vehiculeList.size() - 1) {
                    out.println(",");
                }
            }
            out.println("]");
            out.close();
        } else if (path.equals("/clients")) {
            List<Clienti> clientiList = em.createQuery("SELECT c FROM Clienti c", Clienti.class).getResultList();
            em.close();

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.println("[");
            for (int i = 0; i < clientiList.size(); i++) {
                Clienti client = clientiList.get(i);
                out.println("{\"id\": \"" + client.getId() + "\", \"nume\": \"" + client.getNume() + "\", \"prenume\": \"" + client.getPrenume() + "\", \"email\": \"" + client.getEmail() + "\", \"contact\": \"" + client.getDateContact() + "\", \"istoricAchizitii\": \"" + client.getIstoricAchizitii() + "\"}");
                if (i < clientiList.size() - 1) {
                    out.println(",");
                }
            }
            out.println("]");
            out.close();
        } else if (path.startsWith("/clients/")) {
            Long clientId = Long.parseLong(path.substring("/clients/".length()));
            Clienti client = em.find(Clienti.class, clientId);
            em.close();

            if (client != null) {
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.println("{\"id\": \"" + client.getId() + "\", \"nume\": \"" + client.getNume() + "\", \"prenume\": \"" + client.getPrenume() + "\", \"email\": \"" + client.getEmail() + "\", \"contact\": \"" + client.getDateContact() + "\", \"istoricAchizitii\": \"" + client.getIstoricAchizitii() + "\"}");
                out.close();
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                PrintWriter out = resp.getWriter();
                out.println("{\"status\": \"error\", \"message\": \"Client not found\"}");
                out.close();
            }
        }else if (path.equals("/invoices/count")) {
            Long count = em.createQuery("SELECT COUNT(f) FROM Facturi f", Long.class).getSingleResult();
            em.close();

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.println("{\"count\": " + count + "}");
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        EntityManager em = emf.createEntityManager();

        try {
            if (path.equals("/invoices/save")) {
                String client = req.getParameter("client");
                String formNumber = req.getParameter("formNumber");
                String invoiceDate = req.getParameter("invoiceDate");
                Long vehicleId = Long.parseLong(req.getParameter("vehicleId"));
                String vehicleName = req.getParameter("vehicleName");
                Double vehiclePrice = Double.parseDouble(req.getParameter("vehiclePrice"));
                String vehicleDetails = req.getParameter("vehicleDetails");
                Double vat = Double.parseDouble(req.getParameter("vat"));
                Double totalInvoice = Double.parseDouble(req.getParameter("totalInvoice"));

                Vehicule vehicul = em.find(Vehicule.class, vehicleId);

                Facturi factura = new Facturi(client, formNumber, invoiceDate, vehiclePrice, vat, totalInvoice, vehicul, vehicleDetails);

                em.getTransaction().begin();
                em.persist(factura);
                em.getTransaction().commit();

                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.println("{\"status\": \"success\"}");
                out.close();
            } else if (path.equals("/profil")) {
                String action = req.getParameter("action");
                String dateContact = req.getParameter("contact");
                String istoricAchizitii = req.getParameter("istoricAchizitii");
                String nume = req.getParameter("nume");
                String prenume = req.getParameter("prenume");
                String email = req.getParameter("email");

                if ("create".equalsIgnoreCase(action)) {
                    Clienti client = new Clienti();
                    client.setDateContact(dateContact);
                    client.setIstoricAchizitii(istoricAchizitii);
                    client.setNume(nume);
                    client.setPrenume(prenume);
                    client.setEmail(email);

                    em.getTransaction().begin();
                    em.persist(client);
                    em.getTransaction().commit();
                    System.out.println("Client creat: " + client);

                } else if ("update".equalsIgnoreCase(action)) {
                    Long clientId = Long.parseLong(req.getParameter("clientId"));
                    Clienti client = em.find(Clienti.class, clientId);

                    if (client != null) {
                        em.getTransaction().begin();
                        client.setDateContact(dateContact);
                        client.setIstoricAchizitii(istoricAchizitii);
                        client.setNume(nume);
                        client.setPrenume(prenume);
                        client.setEmail(email);
                        em.getTransaction().commit();
                        System.out.println("Client actualizat: " + client);
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        PrintWriter out = resp.getWriter();
                        out.println("{\"status\": \"error\", \"message\": \"Client not found\"}");
                        out.close();
                        return;
                    }
                } else if ("delete".equalsIgnoreCase(action)) {
                    Long clientId = Long.parseLong(req.getParameter("clientId"));
                    Clienti client = em.find(Clienti.class, clientId);

                    if (client != null) {
                        em.getTransaction().begin();
                        em.remove(client);
                        em.getTransaction().commit();
                        System.out.println("Client șters: " + client);
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        PrintWriter out = resp.getWriter();
                        out.println("{\"status\": \"error\", \"message\": \"Client not found\"}");
                        out.close();
                        return;
                    }
                }

                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.println("{\"status\": \"success\"}");
                out.close();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.println("{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}");
            out.close();
            System.err.println("Eroare la procesarea cererii: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
