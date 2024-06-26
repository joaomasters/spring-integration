/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.support.locks;

import java.util.concurrent.locks.Lock;

/**
 * Strategy for maintaining a registry of shared locks.
 *
 * @author Oleg Zhurakousky
 * @author Gary Russell
 *
 * @since 2.1.1
 */
@FunctionalInterface
public interface LockRegistry {

	/**
	 * Obtains the lock associated with the parameter object.
	 * @param lockKey The object with which the lock is associated.
	 * @return The associated lock.
	 */
	Lock obtain(Object lockKey);

}
