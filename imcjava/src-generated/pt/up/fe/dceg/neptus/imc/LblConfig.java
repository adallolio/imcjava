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
 * $Id:: LblConfig.java 392 2013-02-28 17:26:14Z zepinto@gmail.com             $:
 */

// Source generated by IMCJava from IMC version 5.1.0
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message LBL Configuration (203)<br/>
 *  Long Base Line configuration.<br/>
 */

public class LblConfig extends IMCMessage {

	public static final int ID_STATIC = 203;

	public enum OP {
		SET_CFG(0),
		GET_CFG(1),
		CUR_CFG(2);

		protected long value;

		public long value() {
			return value;
		}

		OP(long value) {
			this.value = value;
		}
	}

	public LblConfig() {
		super(ID_STATIC);
	}

	public LblConfig(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public LblConfig(short op, java.util.Collection<LblBeacon> beacons) {
		super(ID_STATIC);
		setOp(op);
		if (beacons != null)
			setBeacons(beacons);
	}

	/**
	 *  Used to define the type of the operation this message holds.<br/>
	 *  @return Operation (enumerated) - uint8_t
	 */
	public OP getOp() {
		try {
			OP o = OP.valueOf(getMessageType().getFieldPossibleValues("op").get(getLong("op")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  @return Beacons - message-list
	 */
	public java.util.Vector<LblBeacon> getBeacons() {
		try {
			return getMessageList("beacons", LblBeacon.class);
		}
		catch (Exception e) {
			return null;
		}

	}

	/**
	 *  @param op Operation (enumerated)
	 */
	public void setOp(OP op) {
		values.put("op", op.value());
	}

	/**
	 *  @param op Operation (as a String)
	 */
	public void setOp(String op) {
		setValue("op", op);
	}

	/**
	 *  @param op Operation (integer value)
	 */
	public void setOp(short op) {
		setValue("op", op);
	}

	/**
	 *  @param beacons Beacons
	 */
	public void setBeacons(java.util.Collection<LblBeacon> beacons) {
		values.put("beacons", beacons);
	}

}
