/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.internal.util;

import org.jenetics.util.ISeq;
import org.jenetics.util.StaticObject;

/**
 * Some helper methods for safe cast operations.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since 1.5
 * @version 1.5 &mdash; <em>$Date: 2013-10-15 $</em>
 */
public class cast extends StaticObject {
	private cast() {}

	@SuppressWarnings("unchecked")
	public static <A, B extends A> ISeq<A> apply(final ISeq<B> seq) {
		return (ISeq<A>)seq;
	}

}
