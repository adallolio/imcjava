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
 *  IMC Message Reply L3 Scientific Sensors (2011)<br/>
 *  Activation/deactivation of scientific sensors.<br/>
 */

public class ScienceSensorsReply extends IMCMessage {

	public static final int ID_STATIC = 2011;

	public ScienceSensorsReply() {
		super(ID_STATIC);
	}

	public ScienceSensorsReply(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ScienceSensorsReply(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static ScienceSensorsReply create(Object... values) {
		ScienceSensorsReply m = new ScienceSensorsReply();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static ScienceSensorsReply clone(IMCMessage msg) throws Exception {

		ScienceSensorsReply m = new ScienceSensorsReply();
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

	public ScienceSensorsReply(byte adcp, long adcp_dur, long adcp_fr, byte ctd, long ctd_dur, long ctd_fr, byte opt, long opt_dur, long opt_fr, byte tbl, long tbl_dur, long tbl_fr, byte eco, long eco_dur, long eco_fr, byte par, long par_dur, long par_fr) {
		super(ID_STATIC);
		setAdcp(adcp);
		setAdcpDur(adcp_dur);
		setAdcpFr(adcp_fr);
		setCtd(ctd);
		setCtdDur(ctd_dur);
		setCtdFr(ctd_fr);
		setOpt(opt);
		setOptDur(opt_dur);
		setOptFr(opt_fr);
		setTbl(tbl);
		setTblDur(tbl_dur);
		setTblFr(tbl_fr);
		setEco(eco);
		setEcoDur(eco_dur);
		setEcoFr(eco_fr);
		setPar(par);
		setParDur(par_dur);
		setParFr(par_fr);
	}

	/**
	 *  @return ADCP - int8_t
	 */
	public byte getAdcp() {
		return (byte) getInteger("adcp");
	}

	/**
	 *  @param adcp ADCP
	 */
	public ScienceSensorsReply setAdcp(byte adcp) {
		values.put("adcp", adcp);
		return this;
	}

	/**
	 *  @return ADCP duration (s) - uint32_t
	 */
	public long getAdcpDur() {
		return getLong("adcp_dur");
	}

	/**
	 *  @param adcp_dur ADCP duration (s)
	 */
	public ScienceSensorsReply setAdcpDur(long adcp_dur) {
		values.put("adcp_dur", adcp_dur);
		return this;
	}

	/**
	 *  @return ADCP activation frequency (s) - uint32_t
	 */
	public long getAdcpFr() {
		return getLong("adcp_fr");
	}

	/**
	 *  @param adcp_fr ADCP activation frequency (s)
	 */
	public ScienceSensorsReply setAdcpFr(long adcp_fr) {
		values.put("adcp_fr", adcp_fr);
		return this;
	}

	/**
	 *  @return CTD - int8_t
	 */
	public byte getCtd() {
		return (byte) getInteger("ctd");
	}

	/**
	 *  @param ctd CTD
	 */
	public ScienceSensorsReply setCtd(byte ctd) {
		values.put("ctd", ctd);
		return this;
	}

	/**
	 *  @return CTD duration (s) - uint32_t
	 */
	public long getCtdDur() {
		return getLong("ctd_dur");
	}

	/**
	 *  @param ctd_dur CTD duration (s)
	 */
	public ScienceSensorsReply setCtdDur(long ctd_dur) {
		values.put("ctd_dur", ctd_dur);
		return this;
	}

	/**
	 *  @return CTD activation frequency (s) - uint32_t
	 */
	public long getCtdFr() {
		return getLong("ctd_fr");
	}

	/**
	 *  @param ctd_fr CTD activation frequency (s)
	 */
	public ScienceSensorsReply setCtdFr(long ctd_fr) {
		values.put("ctd_fr", ctd_fr);
		return this;
	}

	/**
	 *  @return OPTODE - int8_t
	 */
	public byte getOpt() {
		return (byte) getInteger("opt");
	}

	/**
	 *  @param opt OPTODE
	 */
	public ScienceSensorsReply setOpt(byte opt) {
		values.put("opt", opt);
		return this;
	}

	/**
	 *  @return OPTODE duration (s) - uint32_t
	 */
	public long getOptDur() {
		return getLong("opt_dur");
	}

	/**
	 *  @param opt_dur OPTODE duration (s)
	 */
	public ScienceSensorsReply setOptDur(long opt_dur) {
		values.put("opt_dur", opt_dur);
		return this;
	}

	/**
	 *  @return OPTODE activation frequency (s) - uint32_t
	 */
	public long getOptFr() {
		return getLong("opt_fr");
	}

	/**
	 *  @param opt_fr OPTODE activation frequency (s)
	 */
	public ScienceSensorsReply setOptFr(long opt_fr) {
		values.put("opt_fr", opt_fr);
		return this;
	}

	/**
	 *  @return TBLive - int8_t
	 */
	public byte getTbl() {
		return (byte) getInteger("tbl");
	}

	/**
	 *  @param tbl TBLive
	 */
	public ScienceSensorsReply setTbl(byte tbl) {
		values.put("tbl", tbl);
		return this;
	}

	/**
	 *  @return TBLive duration (s) - uint32_t
	 */
	public long getTblDur() {
		return getLong("tbl_dur");
	}

	/**
	 *  @param tbl_dur TBLive duration (s)
	 */
	public ScienceSensorsReply setTblDur(long tbl_dur) {
		values.put("tbl_dur", tbl_dur);
		return this;
	}

	/**
	 *  @return TBLive activation frequency (s) - uint32_t
	 */
	public long getTblFr() {
		return getLong("tbl_fr");
	}

	/**
	 *  @param tbl_fr TBLive activation frequency (s)
	 */
	public ScienceSensorsReply setTblFr(long tbl_fr) {
		values.put("tbl_fr", tbl_fr);
		return this;
	}

	/**
	 *  @return EcoPuck - int8_t
	 */
	public byte getEco() {
		return (byte) getInteger("eco");
	}

	/**
	 *  @param eco EcoPuck
	 */
	public ScienceSensorsReply setEco(byte eco) {
		values.put("eco", eco);
		return this;
	}

	/**
	 *  @return EcoPuck duration (s) - uint32_t
	 */
	public long getEcoDur() {
		return getLong("eco_dur");
	}

	/**
	 *  @param eco_dur EcoPuck duration (s)
	 */
	public ScienceSensorsReply setEcoDur(long eco_dur) {
		values.put("eco_dur", eco_dur);
		return this;
	}

	/**
	 *  @return EcoPuck activation frequency (s) - uint32_t
	 */
	public long getEcoFr() {
		return getLong("eco_fr");
	}

	/**
	 *  @param eco_fr EcoPuck activation frequency (s)
	 */
	public ScienceSensorsReply setEcoFr(long eco_fr) {
		values.put("eco_fr", eco_fr);
		return this;
	}

	/**
	 *  @return EcoPAR - int8_t
	 */
	public byte getPar() {
		return (byte) getInteger("par");
	}

	/**
	 *  @param par EcoPAR
	 */
	public ScienceSensorsReply setPar(byte par) {
		values.put("par", par);
		return this;
	}

	/**
	 *  @return EcoPAR duration (s) - uint32_t
	 */
	public long getParDur() {
		return getLong("par_dur");
	}

	/**
	 *  @param par_dur EcoPAR duration (s)
	 */
	public ScienceSensorsReply setParDur(long par_dur) {
		values.put("par_dur", par_dur);
		return this;
	}

	/**
	 *  @return EcoPAR activation frequency (s) - uint32_t
	 */
	public long getParFr() {
		return getLong("par_fr");
	}

	/**
	 *  @param par_fr EcoPAR activation frequency (s)
	 */
	public ScienceSensorsReply setParFr(long par_fr) {
		values.put("par_fr", par_fr);
		return this;
	}

}
