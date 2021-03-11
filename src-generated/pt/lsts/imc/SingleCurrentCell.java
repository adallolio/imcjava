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
 *  IMC Message Single Current Cell (2013)<br/>
 *  Underwater current Velocity and Direction at chosen depth.<br/>
 */

public class SingleCurrentCell extends IMCMessage {

	public static final int ID_STATIC = 2013;

	public SingleCurrentCell() {
		super(ID_STATIC);
	}

	public SingleCurrentCell(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SingleCurrentCell(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static SingleCurrentCell create(Object... values) {
		SingleCurrentCell m = new SingleCurrentCell();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static SingleCurrentCell clone(IMCMessage msg) throws Exception {

		SingleCurrentCell m = new SingleCurrentCell();
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

	public SingleCurrentCell(double lat, double lon, String depth, String vel, String dir) {
		super(ID_STATIC);
		setLat(lat);
		setLon(lon);
		if (depth != null)
			setDepth(depth);
		if (vel != null)
			setVel(vel);
		if (dir != null)
			setDir(dir);
	}

	/**
	 *  @return Latitude WGS-84 (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @param lat Latitude WGS-84 (rad)
	 */
	public SingleCurrentCell setLat(double lat) {
		values.put("lat", lat);
		return this;
	}

	/**
	 *  @return Longitude WGS-84 (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @param lon Longitude WGS-84 (rad)
	 */
	public SingleCurrentCell setLon(double lon) {
		values.put("lon", lon);
		return this;
	}

	/**
	 *  @return Cell Depth - plaintext
	 */
	public String getDepth() {
		return getString("depth");
	}

	/**
	 *  @param depth Cell Depth
	 */
	public SingleCurrentCell setDepth(String depth) {
		values.put("depth", depth);
		return this;
	}

	/**
	 *  @return Water Velocity - plaintext
	 */
	public String getVel() {
		return getString("vel");
	}

	/**
	 *  @param vel Water Velocity
	 */
	public SingleCurrentCell setVel(String vel) {
		values.put("vel", vel);
		return this;
	}

	/**
	 *  @return Direction - plaintext
	 */
	public String getDir() {
		return getString("dir");
	}

	/**
	 *  @param dir Direction
	 */
	public SingleCurrentCell setDir(String dir) {
		values.put("dir", dir);
		return this;
	}

}
