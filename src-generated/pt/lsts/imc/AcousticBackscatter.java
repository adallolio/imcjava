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
 *  IMC Message Acoustic Backscatter (1011)<br/>
 *  Amplitude of the acoustic backscatter for each beam.<br/>
 */

public class AcousticBackscatter extends IMCMessage {

	public static final int ID_STATIC = 1011;

	public AcousticBackscatter() {
		super(ID_STATIC);
	}

	public AcousticBackscatter(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AcousticBackscatter(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static AcousticBackscatter create(Object... values) {
		AcousticBackscatter m = new AcousticBackscatter();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static AcousticBackscatter clone(IMCMessage msg) throws Exception {

		AcousticBackscatter m = new AcousticBackscatter();
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

	public AcousticBackscatter(float beam1, float beam2, float beam3, float beam4) {
		super(ID_STATIC);
		setBeam1(beam1);
		setBeam2(beam2);
		setBeam3(beam3);
		setBeam4(beam4);
	}

	/**
	 *  @return Beam 1 (db) - fp32_t
	 */
	public double getBeam1() {
		return getDouble("beam1");
	}

	/**
	 *  @param beam1 Beam 1 (db)
	 */
	public AcousticBackscatter setBeam1(double beam1) {
		values.put("beam1", beam1);
		return this;
	}

	/**
	 *  @return Beam 2 (db) - fp32_t
	 */
	public double getBeam2() {
		return getDouble("beam2");
	}

	/**
	 *  @param beam2 Beam 2 (db)
	 */
	public AcousticBackscatter setBeam2(double beam2) {
		values.put("beam2", beam2);
		return this;
	}

	/**
	 *  @return Beam 3 (db) - fp32_t
	 */
	public double getBeam3() {
		return getDouble("beam3");
	}

	/**
	 *  @param beam3 Beam 3 (db)
	 */
	public AcousticBackscatter setBeam3(double beam3) {
		values.put("beam3", beam3);
		return this;
	}

	/**
	 *  @return Beam 4 (db) - fp32_t
	 */
	public double getBeam4() {
		return getDouble("beam4");
	}

	/**
	 *  @param beam4 Beam 4 (db)
	 */
	public AcousticBackscatter setBeam4(double beam4) {
		values.put("beam4", beam4);
		return this;
	}

}
