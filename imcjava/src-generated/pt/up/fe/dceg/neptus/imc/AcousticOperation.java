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
 * $Id:: AcousticOperation.java 392 2013-02-28 17:26:14Z zepinto@gmail.com     $:
 */

// Source generated by IMCJava from IMC version 5.1.0
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message Acoustic Operation (211)<br/>
 *  Acoustic operation.<br/>
 */

public class AcousticOperation extends IMCMessage {

	public static final int ID_STATIC = 211;

	public enum OP {
		ABORT(0),
		ABORT_IP(1),
		ABORT_TIMEOUT(2),
		ABORT_ACKED(3),
		RANGE(4),
		RANGE_IP(5),
		RANGE_TIMEOUT(6),
		RANGE_RECVED(7),
		BUSY(8),
		UNSUPPORTED(9),
		NO_TXD(10),
		MSG(11),
		MSG_QUEUED(12),
		MSG_IP(13),
		MSG_DONE(14),
		MSG_FAILURE(15),
		MSG_SHORT(16);

		protected long value;

		public long value() {
			return value;
		}

		OP(long value) {
			this.value = value;
		}
	}

	public AcousticOperation() {
		super(ID_STATIC);
	}

	public AcousticOperation(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public AcousticOperation(short op, String system, float range, IMCMessage msg) {
		super(ID_STATIC);
		setOp(op);
		if (system != null)
			setSystem(system);
		setRange(range);
		if (msg != null)
			setMsg(msg);
	}

	/**
	 *  Operation type.<br/>
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
	 *  @return System - plaintext
	 */
	public String getSystem() {
		return getString("system");
	}

	/**
	 *  @return Range (m) - fp32_t
	 */
	public double getRange() {
		return getDouble("range");
	}

	/**
	 *  @return Message To Send - message
	 */
	public IMCMessage getMsg() {
		return getMessage("msg");
	}

	public <T extends IMCMessage> T getMsg(Class<T> clazz) throws Exception {
		return getMessage(clazz, "msg");
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
	 *  @param system System
	 */
	public void setSystem(String system) {
		values.put("system", system);
	}

	/**
	 *  @param range Range (m)
	 */
	public void setRange(double range) {
		values.put("range", range);
	}

	/**
	 *  @param msg Message To Send
	 */
	public void setMsg(IMCMessage msg) {
		values.put("msg", msg);
	}

}
