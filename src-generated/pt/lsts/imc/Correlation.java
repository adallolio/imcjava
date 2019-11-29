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
 *  IMC Message Correlation (1012)<br/>
 *  Correlation of a given beam mesurment relative to the other beam measurement<br/>
 */

public class Correlation extends IMCMessage {

	public static final int ID_STATIC = 1012;

	public Correlation() {
		super(ID_STATIC);
	}

	public Correlation(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Correlation(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static Correlation create(Object... values) {
		Correlation m = new Correlation();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static Correlation clone(IMCMessage msg) throws Exception {

		Correlation m = new Correlation();
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

	public Correlation(short beam1, short beam2, short beam3, short beam4) {
		super(ID_STATIC);
		setBeam1(beam1);
		setBeam2(beam2);
		setBeam3(beam3);
		setBeam4(beam4);
	}

	/**
	 *  @return Beam 1 (%) - uint8_t
	 */
	public short getBeam1() {
		return (short) getInteger("beam1");
	}

	/**
	 *  @param beam1 Beam 1 (%)
	 */
	public Correlation setBeam1(short beam1) {
		values.put("beam1", beam1);
		return this;
	}

	/**
	 *  @return Beam 2 (%) - uint8_t
	 */
	public short getBeam2() {
		return (short) getInteger("beam2");
	}

	/**
	 *  @param beam2 Beam 2 (%)
	 */
	public Correlation setBeam2(short beam2) {
		values.put("beam2", beam2);
		return this;
	}

	/**
	 *  @return Beam 3 (%) - uint8_t
	 */
	public short getBeam3() {
		return (short) getInteger("beam3");
	}

	/**
	 *  @param beam3 Beam 3 (%)
	 */
	public Correlation setBeam3(short beam3) {
		values.put("beam3", beam3);
		return this;
	}

	/**
	 *  @return Beam 4 (%) - uint8_t
	 */
	public short getBeam4() {
		return (short) getInteger("beam4");
	}

	/**
	 *  @param beam4 Beam 4 (%)
	 */
	public Correlation setBeam4(short beam4) {
		values.put("beam4", beam4);
		return this;
	}

}
