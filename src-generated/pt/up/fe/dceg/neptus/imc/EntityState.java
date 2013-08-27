/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2013, Laboratório de Sistemas e Tecnologia Subaquática
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
 *                                                                             $:
 */

// Source generated by IMCJava from IMC version 5.3.x
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message Entity State (1)<br/>
 *  State reported by an entity in the vehicle. The source entity is<br/>
 *  identified in the message header.<br/>
 */

public class EntityState extends IMCMessage {

	public static final int ID_STATIC = 1;

	public static final short EFLA_HUMAN_INTERVENTION = 0x01;

	public enum STATE {
		BOOT(0),
		NORMAL(1),
		FAULT(2),
		ERROR(3),
		FAILURE(4);

		protected long value;

		public long value() {
			return value;
		}

		STATE(long value) {
			this.value = value;
		}
	}

	public EntityState() {
		super(ID_STATIC);
	}

	public EntityState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static EntityState create(Object... values) {
		EntityState m = new EntityState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static EntityState clone(IMCMessage msg) throws Exception {

		EntityState m = new EntityState();
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

	public EntityState(STATE state, short flags, String description) {
		super(ID_STATIC);
		setState(state);
		setFlags(flags);
		if (description != null)
			setDescription(description);
	}

	/**
	 *  State of entity.<br/>
	 *  @return State (enumerated) - uint8_t
	 */
	public STATE getState() {
		try {
			STATE o = STATE.valueOf(getMessageType().getFieldPossibleValues("state").get(getLong("state")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  Complementary entity state flags.<br/>
	 *  @return Flags (bitfield) - uint8_t
	 */
	public short getFlags() {
		return (short) getInteger("flags");
	}

	/**
	 *  @return Complementary description - plaintext
	 */
	public String getDescription() {
		return getString("description");
	}

	/**
	 *  @param state State (enumerated)
	 */
	public void setState(STATE state) {
		values.put("state", state.value());
	}

	/**
	 *  @param state State (as a String)
	 */
	public void setState(String state) {
		setValue("state", state);
	}

	/**
	 *  @param state State (integer value)
	 */
	public void setState(short state) {
		setValue("state", state);
	}

	/**
	 *  @param flags Flags (bitfield)
	 */
	public void setFlags(short flags) {
		values.put("flags", flags);
	}

	/**
	 *  @param description Complementary description
	 */
	public void setDescription(String description) {
		values.put("description", description);
	}

}