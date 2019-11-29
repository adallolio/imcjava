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
 *  IMC Message Vessel Wind (913)<br/>
 *  Measurement of wind speed and angle, in relation to the vessel’s bow/centerline.<br/>
 */

public class VesselWind extends IMCMessage {

	public static final int ID_STATIC = 913;

	public VesselWind() {
		super(ID_STATIC);
	}

	public VesselWind(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VesselWind(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static VesselWind create(Object... values) {
		VesselWind m = new VesselWind();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static VesselWind clone(IMCMessage msg) throws Exception {

		VesselWind m = new VesselWind();
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

	public VesselWind(float angle, String reference, float speed) {
		super(ID_STATIC);
		setAngle(angle);
		if (reference != null)
			setReference(reference);
		setSpeed(speed);
	}

	/**
	 *  @return Angle (°) - fp32_t
	 */
	public double getAngle() {
		return getDouble("angle");
	}

	/**
	 *  @param angle Angle (°)
	 */
	public VesselWind setAngle(double angle) {
		values.put("angle", angle);
		return this;
	}

	/**
	 *  @return Reference - plaintext
	 */
	public String getReference() {
		return getString("reference");
	}

	/**
	 *  @param reference Reference
	 */
	public VesselWind setReference(String reference) {
		values.put("reference", reference);
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
	public VesselWind setSpeed(double speed) {
		values.put("speed", speed);
		return this;
	}

}
