/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2018, Laboratório de Sistemas e Tecnologia Subaquática
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the names of IMC, LSTS, IMCJava nor the names of its 
 *       contributors may be used to endorse or promote products derived from 
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL LABORATORIO DE SISTEMAS E TECNOLOGIA SUBAQUATICA
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package pt.lsts.imc;


/**
 *  IMC Message Collision Avoidance (916)<br/>
 *  Envelope with CAS information.<br/>
 */

public class CollisionAvoidance extends IMCMessage {

	public static final int ID_STATIC = 916;

	public CollisionAvoidance() {
		super(ID_STATIC);
	}

	public CollisionAvoidance(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CollisionAvoidance(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static CollisionAvoidance create(Object... values) {
		CollisionAvoidance m = new CollisionAvoidance();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static CollisionAvoidance clone(IMCMessage msg) throws Exception {

		CollisionAvoidance m = new CollisionAvoidance();
		if (msg == null)
			return m;
		if(msg.definitions != m.definitions){
			msg = msg.cloneMessage();
			IMCUtil.updateMessage(msg, m.definitions);
		}
		else if (msg.getMgid()!=m.getMgid())
			throw new Exception("Argument "+msg.getAbbrev()+" is incompatible with message "+m.getAbbrev());

		m.getHeader().values.putAll(msg.getHeader().values);
		m.values.putAll(msg.values);
		return m;
	}

	public CollisionAvoidance(float mmsi, double lat, double lon, float x, float y, float speed, float course, float dist, float length, float width, float o_vect) {
		super(ID_STATIC);
		setMmsi(mmsi);
		setLat(lat);
		setLon(lon);
		setX(x);
		setY(y);
		setSpeed(speed);
		setCourse(course);
		setDist(dist);
		setLength(length);
		setWidth(width);
		setOVect(o_vect);
	}

	/**
	 *  @return MMSI - fp32_t
	 */
	public double getMmsi() {
		return getDouble("mmsi");
	}

	/**
	 *  @param mmsi MMSI
	 */
	public CollisionAvoidance setMmsi(double mmsi) {
		values.put("mmsi", mmsi);
		return this;
	}

	/**
	 *  @return Latitude (WGS-84) (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @param lat Latitude (WGS-84) (rad)
	 */
	public CollisionAvoidance setLat(double lat) {
		values.put("lat", lat);
		return this;
	}

	/**
	 *  @return Longitude (WGS-84) (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @param lon Longitude (WGS-84) (rad)
	 */
	public CollisionAvoidance setLon(double lon) {
		values.put("lon", lon);
		return this;
	}

	/**
	 *  @return Offset north (m) - fp32_t
	 */
	public double getX() {
		return getDouble("x");
	}

	/**
	 *  @param x Offset north (m)
	 */
	public CollisionAvoidance setX(double x) {
		values.put("x", x);
		return this;
	}

	/**
	 *  @return Offset east (m) - fp32_t
	 */
	public double getY() {
		return getDouble("y");
	}

	/**
	 *  @param y Offset east (m)
	 */
	public CollisionAvoidance setY(double y) {
		values.put("y", y);
		return this;
	}

	/**
	 *  @return Speed (m/s) - fp32_t
	 */
	public double getSpeed() {
		return getDouble("speed");
	}

	/**
	 *  @param speed Speed (m/s)
	 */
	public CollisionAvoidance setSpeed(double speed) {
		values.put("speed", speed);
		return this;
	}

	/**
	 *  @return Course (°) - fp32_t
	 */
	public double getCourse() {
		return getDouble("course");
	}

	/**
	 *  @param course Course (°)
	 */
	public CollisionAvoidance setCourse(double course) {
		values.put("course", course);
		return this;
	}

	/**
	 *  @return Distance (m) - fp32_t
	 */
	public double getDist() {
		return getDouble("dist");
	}

	/**
	 *  @param dist Distance (m)
	 */
	public CollisionAvoidance setDist(double dist) {
		values.put("dist", dist);
		return this;
	}

	/**
	 *  @return Length (m) - fp32_t
	 */
	public double getLength() {
		return getDouble("length");
	}

	/**
	 *  @param length Length (m)
	 */
	public CollisionAvoidance setLength(double length) {
		values.put("length", length);
		return this;
	}

	/**
	 *  @return Width (m) - fp32_t
	 */
	public double getWidth() {
		return getDouble("width");
	}

	/**
	 *  @param width Width (m)
	 */
	public CollisionAvoidance setWidth(double width) {
		values.put("width", width);
		return this;
	}

	/**
	 *  @return Obstacle vector size - fp32_t
	 */
	public double getOVect() {
		return getDouble("o_vect");
	}

	/**
	 *  @param o_vect Obstacle vector size
	 */
	public CollisionAvoidance setOVect(double o_vect) {
		values.put("o_vect", o_vect);
		return this;
	}

}
