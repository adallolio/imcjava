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
 *  IMC Message Obstacle State (364)<br/>
 *  This message presents the estimated state of a obstacle<br/>
 *  which will be sent to the target vehicle.<br/>
 *  Obstacle is a complete description of the system<br/>
 *  in terms of parameters such as position, orientation and<br/>
 *  velocities at a particular moment in time.<br/>
 */

public class ObstacleState extends IMCMessage {

	public static final int ID_STATIC = 364;

	public ObstacleState() {
		super(ID_STATIC);
	}

	public ObstacleState(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObstacleState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static ObstacleState create(Object... values) {
		ObstacleState m = new ObstacleState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static ObstacleState clone(IMCMessage msg) throws Exception {

		ObstacleState m = new ObstacleState();
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

	public ObstacleState(long mmsi, double lon, double lat, float x, float y, float psi, float U, float V, float a, float b, float c, float d) {
		super(ID_STATIC);
		setMmsi(mmsi);
		setLon(lon);
		setLat(lat);
		setX(x);
		setY(y);
		setPsi(psi);
		setU(U);
		setV(V);
		setA(a);
		setB(b);
		setC(c);
		setD(d);
	}

	/**
	 *  @return MMSI - uint32_t
	 */
	public long getMmsi() {
		return getLong("mmsi");
	}

	/**
	 *  @param mmsi MMSI
	 */
	public ObstacleState setMmsi(long mmsi) {
		values.put("mmsi", mmsi);
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
	public ObstacleState setLon(double lon) {
		values.put("lon", lon);
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
	public ObstacleState setLat(double lat) {
		values.put("lat", lat);
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
	public ObstacleState setX(double x) {
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
	public ObstacleState setY(double y) {
		values.put("y", y);
		return this;
	}

	/**
	 *  @return Rotation over z axis (rad) - fp32_t
	 */
	public double getPsi() {
		return getDouble("psi");
	}

	/**
	 *  @param psi Rotation over z axis (rad)
	 */
	public ObstacleState setPsi(double psi) {
		values.put("psi", psi);
		return this;
	}

	/**
	 *  @return Ground Velocity X (North) (m/s) - fp32_t
	 */
	public double getU() {
		return getDouble("U");
	}

	/**
	 *  @param U Ground Velocity X (North) (m/s)
	 */
	public ObstacleState setU(double U) {
		values.put("U", U);
		return this;
	}

	/**
	 *  @return Ground Velocity Y (East) (m/s) - fp32_t
	 */
	public double getV() {
		return getDouble("V");
	}

	/**
	 *  @param V Ground Velocity Y (East) (m/s)
	 */
	public ObstacleState setV(double V) {
		values.put("V", V);
		return this;
	}

	/**
	 *  @return Size A Lenght (m) - fp32_t
	 */
	public double getA() {
		return getDouble("a");
	}

	/**
	 *  @param a Size A Lenght (m)
	 */
	public ObstacleState setA(double a) {
		values.put("a", a);
		return this;
	}

	/**
	 *  @return Size B Length (m) - fp32_t
	 */
	public double getB() {
		return getDouble("b");
	}

	/**
	 *  @param b Size B Length (m)
	 */
	public ObstacleState setB(double b) {
		values.put("b", b);
		return this;
	}

	/**
	 *  @return Size C Width (m) - fp32_t
	 */
	public double getC() {
		return getDouble("c");
	}

	/**
	 *  @param c Size C Width (m)
	 */
	public ObstacleState setC(double c) {
		values.put("c", c);
		return this;
	}

	/**
	 *  @return Size D Width (m) - fp32_t
	 */
	public double getD() {
		return getDouble("d");
	}

	/**
	 *  @param d Size D Width (m)
	 */
	public ObstacleState setD(double d) {
		values.put("d", d);
		return this;
	}

}
