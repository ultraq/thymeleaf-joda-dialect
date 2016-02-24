/* 
 * Copyright 2016, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf

import org.thymeleaf.context.IExpressionContext
import org.thymeleaf.expression.IExpressionObjectFactory

/**
 * Creates the Joda expression object when needed.
 * 
 * @author Emanuel Rabina
 */
class JodaExpressionObjectFactory implements IExpressionObjectFactory {

	static final String JODA_EXPRESSION_OBJECT_NAME = 'joda'

	final Set<String> allExpressionObjectNames = [
		JODA_EXPRESSION_OBJECT_NAME
	]

	/**
	 * {@inheritDoc}
	 */
	@Override
	Object buildObject(IExpressionContext context, String expressionObjectName) {

		return expressionObjectName == JODA_EXPRESSION_OBJECT_NAME ? new JodaExpressionObject() : null
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean isCacheable(String expressionObjectName) {

		return expressionObjectName == JODA_EXPRESSION_OBJECT_NAME
	}
}
