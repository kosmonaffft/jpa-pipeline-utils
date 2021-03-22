// Copyright 2021 Anton V. Kirilchik <kosmonaffft@gmail.com>
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package space.kosmonaffft.utils.jpa;

import jakarta.persistence.EntityManager;
import space.kosmonaffft.utils.jpa.base.MapperNew;
import space.kosmonaffft.utils.jpa.impl.SelectByIdPipeline;

import java.io.Serializable;
import java.util.function.Supplier;

public class EntityLogic {

    private final EntityManager entityManager;

    public EntityLogic(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <EntityClass, EntityIdClass extends Serializable, DtoClass> Object select() {
        return new Object();
    }

    public <EntityClass, EntityIdClass extends Serializable, DtoClass> SelectByIdPipeline<EntityClass, EntityIdClass, DtoClass> select(Class<EntityClass> entityClass,
                                                                                                                                       Supplier<MapperNew<EntityClass, DtoClass>> mapperSupplier) {
        return new SelectByIdPipeline<EntityClass, EntityIdClass, DtoClass>(entityManager, entityClass, mapperSupplier.get());
    }

    public <EntityClass, EntityIdClass extends Serializable, DtoClass> Object create() {
        return new Object();
    }

    public <EntityClass, EntityIdClass extends Serializable, DtoClass> Object update(EntityClass id) {
        return new Object();
    }

    public <EntityClass, EntityIdClass extends Serializable, DtoClass> Object delete(EntityIdClass id) {
        return new Object();
    }
}
