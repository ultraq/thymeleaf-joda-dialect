/* 
 * Copyright 2015, Emanuel Rabina (http://www.ultraq.net.nz/)
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

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Class to provide Joda functionality in Thymeleaf templates.
 * 
 * @author Emanuel Rabina
 */
class JodaExpressionObject {

	/**
	 * Create a new DateTime object.
	 * 
	 * @return New DateTime object for the current time.
	 */
	DateTime createNow() {

		return new DateTime()
	}

	/**
	 * Format any type of date object using Joda formatters.
	 * 
	 * @param dateTime
	 * @param pattern
	 * @return Formatted datetime string.
	 */
	String format(DateTime dateTime, String pattern) {

		return dateTime != null ? DateTimeFormat.forPattern(pattern).print(dateTime) : null
	}
}
