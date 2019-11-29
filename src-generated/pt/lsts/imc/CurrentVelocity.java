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
 *  IMC Message Current Velocity (910)<br/>
 *  Current velocity at a given distance below the vehicle.<br/>
 */

public class CurrentVelocity extends IMCMessage {

	public static final int ID_STATIC = 910;

	public CurrentVelocity() {
		super(ID_STATIC);
	}

	public CurrentVelocity(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CurrentVelocity(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static CurrentVelocity create(Object... values) {
		CurrentVelocity m = new CurrentVelocity();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static CurrentVelocity clone(IMCMessage msg) throws Exception {

		CurrentVelocity m = new CurrentVelocity();
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

	public CurrentVelocity(float x, float y, float z1, float z2) {
		super(ID_STATIC);
		setX(x);
		setY(y);
		setZ1(z1);
		setZ2(z2);
	}

	/**
	 *  @return X (m/s) - fp32_t
	 */
	public double getX() {
		return getDouble("x");
	}

	/**
	 *  @param x X (m/s)
	 */
	public CurrentVelocity setX(double x) {
		values.put("x", x);
		return this;
	}

	/**
	 *  @return Y (m/s) - fp32_t
	 */
	public double getY() {
		return getDouble("y");
	}

	/**
	 *  @param y Y (m/s)
	 */
	public CurrentVelocity setY(double y) {
		values.put("y", y);
		return this;
	}

	/**
	 *  @return Z1 (m/s) - fp32_t
	 */
	public double getZ1() {
		return getDouble("z1");
	}

	/**
	 *  @param z1 Z1 (m/s)
	 */
	public CurrentVelocity setZ1(double z1) {
		values.put("z1", z1);
		return this;
	}

	/**
	 *  @return Z2 (m/s) - fp32_t
	 */
	public double getZ2() {
		return getDouble("z2");
	}

	/**
	 *  @param z2 Z2 (m/s)
	 */
	public CurrentVelocity setZ2(double z2) {
		values.put("z2", z2);
		return this;
	}

}
