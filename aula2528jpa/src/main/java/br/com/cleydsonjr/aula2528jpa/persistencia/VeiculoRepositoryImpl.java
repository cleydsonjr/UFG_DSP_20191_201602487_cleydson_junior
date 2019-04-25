package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("WeakerAccess")
public class VeiculoRepositoryImpl implements VeiculoRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.cleydsonjr.aula2528jpa");
    private EntityManager entityManager;

    public VeiculoRepositoryImpl() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Veiculo save(Veiculo veiculo) throws Exception {
        return this.transactional(() -> {
            entityManager.persist(veiculo);
            return veiculo;
        });
    }

    @Override
    public Veiculo get(Long id) {
        return entityManager.find(Veiculo.class, id);
    }

    @Override
    public List<Veiculo> findByMarcaAndModelo(String marca, String modelo) {
        Query query = entityManager.createQuery("select veiculo from Veiculo veiculo where veiculo.marca = :marca and veiculo.modelo like :modelo");
        query.setParameter("marca", marca);
        query.setParameter("modelo", modelo);

        return query.getResultList();
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        entityManager.getTransaction().begin();
        veiculo = entityManager.merge(veiculo);
        entityManager.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) throws Exception {
        this.<Void>transactional(() -> {
            entityManager.remove(veiculo);

            return null;
        });
        entityManager.getTransaction().begin();
        entityManager.remove(veiculo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManagerFactory.close();
    }

    private <T> T transactional(Callable<T> callable) throws Exception {
        entityManager.getTransaction().begin();
        T result = callable.call();
        entityManager.getTransaction().commit();

        return result;
    }

}
