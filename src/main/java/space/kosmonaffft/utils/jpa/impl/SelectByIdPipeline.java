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

package space.kosmonaffft.utils.jpa.impl;

import jakarta.persistence.EntityManager;
import space.kosmonaffft.utils.jpa.base.MapperNew;

import java.io.Serializable;
import java.util.Optional;

public class SelectByIdPipeline<EntityClass, EntityIdClass extends Serializable, DtoClass> {

    private final EntityManager entityManager;

    private final Class<EntityClass> entityClass;

    private final MapperNew<EntityClass, DtoClass> mapperNew;

    private Optional<EntityIdClass> entityId = Optional.empty();

    public SelectByIdPipeline(EntityManager entityManager,
                              Class<EntityClass> entityClass,
                              MapperNew<EntityClass, DtoClass> mapperNew) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
        this.mapperNew = mapperNew;
    }

    public SelectByIdPipeline<EntityClass, EntityIdClass, DtoClass> id(EntityIdClass id) {
        this.entityId = Optional.of(id);
        return this;
    }

    public DtoClass execute() {
        EntityIdClass id = entityId.orElseThrow();
        EntityClass entity = entityManager.find(this.entityClass, id);
        DtoClass dto = mapperNew.map(entity);
        return dto;
    }
}
