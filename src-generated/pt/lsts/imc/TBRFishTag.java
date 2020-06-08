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
 *  IMC Message TBR Fish Tag (2007)<br/>
 *  TBR700RT received fish tag detection<br/>
 */

public class TBRFishTag extends IMCMessage {

	public enum TRANS_PROTOCOL {
		R256(1),
		R04K(2),
		R64K(4),
		R01M(5),
		S256(6),
		S64K(3),
		HS256(7),
		DS256(8);

		protected long value;

		public long value() {
			return value;
		}

		TRANS_PROTOCOL(long value) {
			this.value = value;
		}
	}

	public static final int ID_STATIC = 2007;

	public TBRFishTag() {
		super(ID_STATIC);
	}

	public TBRFishTag(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TBRFishTag(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static TBRFishTag create(Object... values) {
		TBRFishTag m = new TBRFishTag();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static TBRFishTag clone(IMCMessage msg) throws Exception {

		TBRFishTag m = new TBRFishTag();
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

	public TBRFishTag(long serial_no, long unix_timestamp, int millis, TRANS_PROTOCOL trans_protocol, long trans_id, int trans_data, short SNR, short trans_freq, int recv_mem_addr, double lat, double lon) {
		super(ID_STATIC);
		setSerialNo(serial_no);
		setUnixTimestamp(unix_timestamp);
		setMillis(millis);
		setTransProtocol(trans_protocol);
		setTransId(trans_id);
		setTransData(trans_data);
		setSNR(SNR);
		setTransFreq(trans_freq);
		setRecvMemAddr(recv_mem_addr);
		setLat(lat);
		setLon(lon);
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
	public TBRFishTag setSerialNo(long serial_no) {
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
	public TBRFishTag setUnixTimestamp(long unix_timestamp) {
		values.put("unix_timestamp", unix_timestamp);
		return this;
	}

	/**
	 *  @return Millisecond (ms) - uint16_t
	 */
	public int getMillis() {
		return getInteger("millis");
	}

	/**
	 *  @param millis Millisecond (ms)
	 */
	public TBRFishTag setMillis(int millis) {
		values.put("millis", millis);
		return this;
	}

	/**
	 *  @return Transmit Protocol (enumerated) - uint8_t
	 */
	public TRANS_PROTOCOL getTransProtocol() {
		try {
			TRANS_PROTOCOL o = TRANS_PROTOCOL.valueOf(getMessageType().getFieldPossibleValues("trans_protocol").get(getLong("trans_protocol")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	public String getTransProtocolStr() {
		return getString("trans_protocol");
	}

	public short getTransProtocolVal() {
		return (short) getInteger("trans_protocol");
	}

	/**
	 *  @param trans_protocol Transmit Protocol (enumerated)
	 */
	public TBRFishTag setTransProtocol(TRANS_PROTOCOL trans_protocol) {
		values.put("trans_protocol", trans_protocol.value());
		return this;
	}

	/**
	 *  @param trans_protocol Transmit Protocol (as a String)
	 */
	public TBRFishTag setTransProtocolStr(String trans_protocol) {
		setValue("trans_protocol", trans_protocol);
		return this;
	}

	/**
	 *  @param trans_protocol Transmit Protocol (integer value)
	 */
	public TBRFishTag setTransProtocolVal(short trans_protocol) {
		setValue("trans_protocol", trans_protocol);
		return this;
	}

	/**
	 *  @return Transmitter ID - uint32_t
	 */
	public long getTransId() {
		return getLong("trans_id");
	}

	/**
	 *  @param trans_id Transmitter ID
	 */
	public TBRFishTag setTransId(long trans_id) {
		values.put("trans_id", trans_id);
		return this;
	}

	/**
	 *  @return Transmitter Data - uint16_t
	 */
	public int getTransData() {
		return getInteger("trans_data");
	}

	/**
	 *  @param trans_data Transmitter Data
	 */
	public TBRFishTag setTransData(int trans_data) {
		values.put("trans_data", trans_data);
		return this;
	}

	/**
	 *  @return Signal to Noise Ratio (db) - uint8_t
	 */
	public short getSNR() {
		return (short) getInteger("SNR");
	}

	/**
	 *  @param SNR Signal to Noise Ratio (db)
	 */
	public TBRFishTag setSNR(short SNR) {
		values.put("SNR", SNR);
		return this;
	}

	/**
	 *  @return Transmitter Detection Frequency - uint8_t
	 */
	public short getTransFreq() {
		return (short) getInteger("trans_freq");
	}

	/**
	 *  @param trans_freq Transmitter Detection Frequency
	 */
	public TBRFishTag setTransFreq(short trans_freq) {
		values.put("trans_freq", trans_freq);
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
	public TBRFishTag setRecvMemAddr(int recv_mem_addr) {
		values.put("recv_mem_addr", recv_mem_addr);
		return this;
	}

	/**
	 *  @return Latitude (WGS-84) (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @param lat Latitude (WGS-84) (rad)
	 */
	public TBRFishTag setLat(double lat) {
		values.put("lat", lat);
		return this;
	}

	/**
	 *  @return Longitude (WGS-84) (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @param lon Longitude (WGS-84) (rad)
	 */
	public TBRFishTag setLon(double lon) {
		values.put("lon", lon);
		return this;
	}

}
