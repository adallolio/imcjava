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
 *  IMC Message AutoNaut Power Settings (912)<br/>
 */

public class PowerSettings extends IMCMessage {

	public static final int ID_STATIC = 912;

	public PowerSettings() {
		super(ID_STATIC);
	}

	public PowerSettings(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PowerSettings(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static PowerSettings create(Object... values) {
		PowerSettings m = new PowerSettings();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static PowerSettings clone(IMCMessage msg) throws Exception {

		PowerSettings m = new PowerSettings();
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

	public PowerSettings(byte l2, byte l3, byte iridium, byte modem, byte pumps, byte vhf) {
		super(ID_STATIC);
		setL2(l2);
		setL3(l3);
		setIridium(iridium);
		setModem(modem);
		setPumps(pumps);
		setVhf(vhf);
	}

	/**
	 *  @return Level2 - int8_t
	 */
	public byte getL2() {
		return (byte) getInteger("l2");
	}

	/**
	 *  @param l2 Level2
	 */
	public PowerSettings setL2(byte l2) {
		values.put("l2", l2);
		return this;
	}

	/**
	 *  @return Level3 - int8_t
	 */
	public byte getL3() {
		return (byte) getInteger("l3");
	}

	/**
	 *  @param l3 Level3
	 */
	public PowerSettings setL3(byte l3) {
		values.put("l3", l3);
		return this;
	}

	/**
	 *  @return Iridium - int8_t
	 */
	public byte getIridium() {
		return (byte) getInteger("iridium");
	}

	/**
	 *  @param iridium Iridium
	 */
	public PowerSettings setIridium(byte iridium) {
		values.put("iridium", iridium);
		return this;
	}

	/**
	 *  @return Modem - int8_t
	 */
	public byte getModem() {
		return (byte) getInteger("modem");
	}

	/**
	 *  @param modem Modem
	 */
	public PowerSettings setModem(byte modem) {
		values.put("modem", modem);
		return this;
	}

	/**
	 *  @return Pumps - int8_t
	 */
	public byte getPumps() {
		return (byte) getInteger("pumps");
	}

	/**
	 *  @param pumps Pumps
	 */
	public PowerSettings setPumps(byte pumps) {
		values.put("pumps", pumps);
		return this;
	}

	/**
	 *  @return VHF - int8_t
	 */
	public byte getVhf() {
		return (byte) getInteger("vhf");
	}

	/**
	 *  @param vhf VHF
	 */
	public PowerSettings setVhf(byte vhf) {
		values.put("vhf", vhf);
		return this;
	}

}
