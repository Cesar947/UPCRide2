import com.upcride.entity.Solicitud;
import com.upcride.repository.SolicitudRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sebas
 */
public class SolicitudRepositoryImpl implements SolicitudRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "UPCRidePU")
    private EntityManager em;

    @Override
    public Integer insert(Solicitud v) throws Exception {
        em.persist(v);
        return v.getCodigoSolicitud();
    }

    @Override
    public Integer update(Solicitud v) throws Exception {
        em.merge(v);
        return v.getCodigoSolicitud();
    }

    @Override
    public Integer delete(Solicitud v) throws Exception {
        em.remove(v);
        return v.getCodigoSolicitud();
    }

    @Override
    public List<Solicitud> list() throws Exception {
        List<Solicitud> viajes = new ArrayList<>();
        Query q = em.createQuery("Select s from Solicitud s");
        viajes = (List<Solicitud>) q.getResultList();
        return viajes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Solicitud findById(Solicitud v) throws Exception {
        List<Solicitud> viajes = new ArrayList<>();
        Query q = em.createQuery("SELECT s FROM Solicitud s where s.codigoSolicitud = ?1");
        q.setParameter(1, v.getCodigoSolicitud());

        viajes = (List<Solicitud>) q.getResultList();

        return viajes != null && !viajes.isEmpty() ? viajes.get(0) : new Solicitud();
    }

}
