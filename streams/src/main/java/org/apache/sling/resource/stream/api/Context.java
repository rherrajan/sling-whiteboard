/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.resource.stream.api;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.sling.api.resource.Resource;

public interface Context {

    Context addFunction(String name, BiFunction<List<Function<Resource, Object>>, Resource, Object> functionImpl);

    Context removeFunction(String name);

    Context addArgument(String name, Object object);

    Visitor<Predicate<Resource>> getLogicVisitor();

    Visitor<Function<Resource, Object>> getComparisonVisitor();

    void setLogicVisitor(Visitor<Predicate<Resource>> logicVisitor);

    void setComparionVisitor(Visitor<Function<Resource, Object>> comparisonVisitor);

    Optional<BiFunction<List<Function<Resource, Object>>, Resource, Object>> getFunction(String text);

    Optional<Object> getArgument(String text);

}
