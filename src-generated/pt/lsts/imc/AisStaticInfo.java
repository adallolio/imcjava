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
 *  IMC Message AIS Static Info (607)<br/>
 *  The CUCS receives a AIS message containing static informations that info composes to this message.<br/>
 */

public class AisStaticInfo extends IMCMessage {

	public static final int ID_STATIC = 607;

	public AisStaticInfo() {
		super(ID_STATIC);
	}

	public AisStaticInfo(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AisStaticInfo(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static AisStaticInfo create(Object... values) {
		AisStaticInfo m = new AisStaticInfo();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static AisStaticInfo clone(IMCMessage msg) throws Exception {

		AisStaticInfo m = new AisStaticInfo();
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

	public AisStaticInfo(String id, String callsign, String name, short type_and_cargo, float a, float b, float c, float d) {
		super(ID_STATIC);
		if (id != null)
			setId(id);
		if (callsign != null)
			setCallsign(callsign);
		if (name != null)
			setName(name);
		setTypeAndCargo(type_and_cargo);
		setA(a);
		setB(b);
		setC(c);
		setD(d);
	}

	/**
	 *  @return Id - plaintext
	 */
	public String getId() {
		return getString("id");
	}

	/**
	 *  @param id Id
	 */
	public AisStaticInfo setId(String id) {
		values.put("id", id);
		return this;
	}

	/**
	 *  @return Callsign - plaintext
	 */
	public String getCallsign() {
		return getString("callsign");
	}

	/**
	 *  @param callsign Callsign
	 */
	public AisStaticInfo setCallsign(String callsign) {
		values.put("callsign", callsign);
		return this;
	}

	/**
	 *  @return Name - plaintext
	 */
	public String getName() {
		return getString("name");
	}

	/**
	 *  @param name Name
	 */
	public AisStaticInfo setName(String name) {
		values.put("name", name);
		return this;
	}

	/**
	 *  @return Type and Cargo - uint8_t
	 */
	public short getTypeAndCargo() {
		return (short) getInteger("type_and_cargo");
	}

	/**
	 *  @param type_and_cargo Type and Cargo
	 */
	public AisStaticInfo setTypeAndCargo(short type_and_cargo) {
		values.put("type_and_cargo", type_and_cargo);
		return this;
	}

	/**
	 *  @return Size A Length (m) - fp32_t
	 */
	public double getA() {
		return getDouble("a");
	}

	/**
	 *  @param a Size A Length (m)
	 */
	public AisStaticInfo setA(double a) {
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
	public AisStaticInfo setB(double b) {
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
	public AisStaticInfo setC(double c) {
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
	public AisStaticInfo setD(double d) {
		values.put("d", d);
		return this;
	}

}
