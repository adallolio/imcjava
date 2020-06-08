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
 *  IMC Message TBR Sensor Reading (2008)<br/>
 *  TBR700RT internal sensor reading<br/>
 */

public class TBRSensor extends IMCMessage {

	public static final int ID_STATIC = 2008;

	public TBRSensor() {
		super(ID_STATIC);
	}

	public TBRSensor(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TBRSensor(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static TBRSensor create(Object... values) {
		TBRSensor m = new TBRSensor();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static TBRSensor clone(IMCMessage msg) throws Exception {

		TBRSensor m = new TBRSensor();
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

	public TBRSensor(long serial_no, long unix_timestamp, float temperature, short avg_noise_level, short peak_noise_level, short recv_listen_freq, int recv_mem_addr) {
		super(ID_STATIC);
		setSerialNo(serial_no);
		setUnixTimestamp(unix_timestamp);
		setTemperature(temperature);
		setAvgNoiseLevel(avg_noise_level);
		setPeakNoiseLevel(peak_noise_level);
		setRecvListenFreq(recv_listen_freq);
		setRecvMemAddr(recv_mem_addr);
	}

	/**
	 *  @return TBR serial number - uint32_t
	 */
	public long getSerialNo() {
		return getLong("serial_no");
	}

	/**
	 *  @param serial_no TBR serial number
	 */
	public TBRSensor setSerialNo(long serial_no) {
		values.put("serial_no", serial_no);
		return this;
	}

	/**
	 *  @return UNIX Timestamp - uint32_t
	 */
	public long getUnixTimestamp() {
		return getLong("unix_timestamp");
	}

	/**
	 *  @param unix_timestamp UNIX Timestamp
	 */
	public TBRSensor setUnixTimestamp(long unix_timestamp) {
		values.put("unix_timestamp", unix_timestamp);
		return this;
	}

	/**
	 *  @return Temperature (°c) - fp32_t
	 */
	public double getTemperature() {
		return getDouble("temperature");
	}

	/**
	 *  @param temperature Temperature (°c)
	 */
	public TBRSensor setTemperature(double temperature) {
		values.put("temperature", temperature);
		return this;
	}

	/**
	 *  @return Average noise level - uint8_t
	 */
	public short getAvgNoiseLevel() {
		return (short) getInteger("avg_noise_level");
	}

	/**
	 *  @param avg_noise_level Average noise level
	 */
	public TBRSensor setAvgNoiseLevel(short avg_noise_level) {
		values.put("avg_noise_level", avg_noise_level);
		return this;
	}

	/**
	 *  @return Peak noise level, - uint8_t
	 */
	public short getPeakNoiseLevel() {
		return (short) getInteger("peak_noise_level");
	}

	/**
	 *  @param peak_noise_level Peak noise level,
	 */
	public TBRSensor setPeakNoiseLevel(short peak_noise_level) {
		values.put("peak_noise_level", peak_noise_level);
		return this;
	}

	/**
	 *  @return Receiver listening frequency - uint8_t
	 */
	public short getRecvListenFreq() {
		return (short) getInteger("recv_listen_freq");
	}

	/**
	 *  @param recv_listen_freq Receiver listening frequency
	 */
	public TBRSensor setRecvListenFreq(short recv_listen_freq) {
		values.put("recv_listen_freq", recv_listen_freq);
		return this;
	}

	/**
	 *  @return Receiver Memory Address - uint16_t
	 */
	public int getRecvMemAddr() {
		return getInteger("recv_mem_addr");
	}

	/**
	 *  @param recv_mem_addr Receiver Memory Address
	 */
	public TBRSensor setRecvMemAddr(int recv_mem_addr) {
		values.put("recv_mem_addr", recv_mem_addr);
		return this;
	}

}
