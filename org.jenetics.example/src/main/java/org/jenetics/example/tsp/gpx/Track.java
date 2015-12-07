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
package org.jenetics.example.tsp.gpx;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents a GPX track.
 */
@XmlJavaTypeAdapter(Track.Model.Adapter.class)
public final class Track implements Iterable<TrackSegment> {
	private final List<TrackSegment> _segments = new ArrayList<>();

	public Track() {
	}

	public void add(final TrackSegment segment) {
		_segments.add(requireNonNull(segment));
	}

	@Override
	public Iterator<TrackSegment> iterator() {
		return null;
	}

	public Stream<TrackSegment> stream() {
		return _segments.stream();
	}

	@XmlRootElement(name = "trk")
	@XmlType(name = "gpx.Track")
	@XmlAccessorType(XmlAccessType.FIELD)
	static final class Model {

		@XmlElement(name = "trkseg", required = false, nillable = true)
		public List<TrackSegment> segments;

		public static final class Adapter
			extends XmlAdapter<Model, Track>
		{
			@Override
			public Model marshal(final Track track) {
				final Model model = new Model();
				model.segments = !track._segments.isEmpty()
					? track._segments
					: null;

				return model;
			}

			@Override
			public Track unmarshal(final Model model) {
				final Track track = new Track();
				if (model.segments != null) {
					model.segments.forEach(track::add);
				}

				return track;
			}
		}
	}

}