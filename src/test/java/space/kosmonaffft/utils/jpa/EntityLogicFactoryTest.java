package space.kosmonaffft.utils.jpa;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import space.kosmonaffft.utils.jpa.base.MapperNew;

class EntityLogicFactoryTest {

    private static EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManager = Mockito.mock(EntityManager.class);
    }

    @Test
    void selectById() {
        EntityLogic entityLogic = EntityLogicFactory.build(entityManager);
        entityLogic.select(Object.class, () -> new MapperNew<Object, Object>() {
            @Override
            public Object map(Object from) {
                return null;
            }

            @Override
            public void map(Object from, Object to) {

            }
        }).id(10L).execute();
    }
}
