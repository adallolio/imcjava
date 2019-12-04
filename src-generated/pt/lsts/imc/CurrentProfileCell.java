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
 *  IMC Message Current Profile Cell (1014)<br/>
 *  Raw Current measurement at CellPosition along the Z-axis in the ADCP sensor frame.<br/>
 */

public class CurrentProfileCell extends IMCMessage {

	public static final int ID_STATIC = 1014;

	public CurrentProfileCell() {
		super(ID_STATIC);
	}

	public CurrentProfileCell(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CurrentProfileCell(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static CurrentProfileCell create(Object... values) {
		CurrentProfileCell m = new CurrentProfileCell();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static CurrentProfileCell clone(IMCMessage msg) throws Exception {

		CurrentProfileCell m = new CurrentProfileCell();
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

	public CurrentProfileCell(float CellPosition, float x, float y, float z1, float z2, float amp0, float amp1, float amp2, float amp3, short cor0, short cor1, short cor2, short cor3) {
		super(ID_STATIC);
		setCellPosition(CellPosition);
		setX(x);
		setY(y);
		setZ1(z1);
		setZ2(z2);
		setAmp0(amp0);
		setAmp1(amp1);
		setAmp2(amp2);
		setAmp3(amp3);
		setCor0(cor0);
		setCor1(cor1);
		setCor2(cor2);
		setCor3(cor3);
	}

	/**
	 *  @return Cell Position (m) - fp32_t
	 */
	public double getCellPosition() {
		return getDouble("CellPosition");
	}

	/**
	 *  @param CellPosition Cell Position (m)
	 */
	public CurrentProfileCell setCellPosition(double CellPosition) {
		values.put("CellPosition", CellPosition);
		return this;
	}

	/**
	 *  @return Vel X (m/s) - fp32_t
	 */
	public double getX() {
		return getDouble("x");
	}

	/**
	 *  @param x Vel X (m/s)
	 */
	public CurrentProfileCell setX(double x) {
		values.put("x", x);
		return this;
	}

	/**
	 *  @return Vel Y (m/s) - fp32_t
	 */
	public double getY() {
		return getDouble("y");
	}

	/**
	 *  @param y Vel Y (m/s)
	 */
	public CurrentProfileCell setY(double y) {
		values.put("y", y);
		return this;
	}

	/**
	 *  @return Vel Z1 (m/s) - fp32_t
	 */
	public double getZ1() {
		return getDouble("z1");
	}

	/**
	 *  @param z1 Vel Z1 (m/s)
	 */
	public CurrentProfileCell setZ1(double z1) {
		values.put("z1", z1);
		return this;
	}

	/**
	 *  @return Vel Z2 (m/s) - fp32_t
	 */
	public double getZ2() {
		return getDouble("z2");
	}

	/**
	 *  @param z2 Vel Z2 (m/s)
	 */
	public CurrentProfileCell setZ2(double z2) {
		values.put("z2", z2);
		return this;
	}

	/**
	 *  @return Amp 0 (db) - fp32_t
	 */
	public double getAmp0() {
		return getDouble("amp0");
	}

	/**
	 *  @param amp0 Amp 0 (db)
	 */
	public CurrentProfileCell setAmp0(double amp0) {
		values.put("amp0", amp0);
		return this;
	}

	/**
	 *  @return Amp 1 (db) - fp32_t
	 */
	public double getAmp1() {
		return getDouble("amp1");
	}

	/**
	 *  @param amp1 Amp 1 (db)
	 */
	public CurrentProfileCell setAmp1(double amp1) {
		values.put("amp1", amp1);
		return this;
	}

	/**
	 *  @return Amp 2 (db) - fp32_t
	 */
	public double getAmp2() {
		return getDouble("amp2");
	}

	/**
	 *  @param amp2 Amp 2 (db)
	 */
	public CurrentProfileCell setAmp2(double amp2) {
		values.put("amp2", amp2);
		return this;
	}

	/**
	 *  @return Amp 3 (db) - fp32_t
	 */
	public double getAmp3() {
		return getDouble("amp3");
	}

	/**
	 *  @param amp3 Amp 3 (db)
	 */
	public CurrentProfileCell setAmp3(double amp3) {
		values.put("amp3", amp3);
		return this;
	}

	/**
	 *  @return Cor 0 (%) - uint8_t
	 */
	public short getCor0() {
		return (short) getInteger("cor0");
	}

	/**
	 *  @param cor0 Cor 0 (%)
	 */
	public CurrentProfileCell setCor0(short cor0) {
		values.put("cor0", cor0);
		return this;
	}

	/**
	 *  @return Cor 1 (%) - uint8_t
	 */
	public short getCor1() {
		return (short) getInteger("cor1");
	}

	/**
	 *  @param cor1 Cor 1 (%)
	 */
	public CurrentProfileCell setCor1(short cor1) {
		values.put("cor1", cor1);
		return this;
	}

	/**
	 *  @return Cor 2 (%) - uint8_t
	 */
	public short getCor2() {
		return (short) getInteger("cor2");
	}

	/**
	 *  @param cor2 Cor 2 (%)
	 */
	public CurrentProfileCell setCor2(short cor2) {
		values.put("cor2", cor2);
		return this;
	}

	/**
	 *  @return Cor 3 (%) - uint8_t
	 */
	public short getCor3() {
		return (short) getInteger("cor3");
	}

	/**
	 *  @param cor3 Cor 3 (%)
	 */
	public CurrentProfileCell setCor3(short cor3) {
		values.put("cor3", cor3);
		return this;
	}

}
