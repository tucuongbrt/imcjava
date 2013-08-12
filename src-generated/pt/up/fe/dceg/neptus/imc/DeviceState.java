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

// Source generated by IMCJava from IMC version 5.2.0
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message Device State (282)<br/>
 *  Location of a specific device in the system infrastructure.<br/>
 */

public class DeviceState extends IMCMessage {

	public static final int ID_STATIC = 282;

	public DeviceState() {
		super(ID_STATIC);
	}

	public DeviceState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static DeviceState create(Object... values) {
		DeviceState m = new DeviceState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static DeviceState clone(IMCMessage msg) throws Exception {

		DeviceState m = new DeviceState();
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

	public DeviceState(float x, float y, float z, float phi, float theta, float psi) {
		super(ID_STATIC);
		setX(x);
		setY(y);
		setZ(z);
		setPhi(phi);
		setTheta(theta);
		setPsi(psi);
	}

	/**
	 *  @return Device Position - X (m) - fp32_t
	 */
	public double getX() {
		return getDouble("x");
	}

	/**
	 *  @return Device Position - Y (m) - fp32_t
	 */
	public double getY() {
		return getDouble("y");
	}

	/**
	 *  @return Device Position - Z (m) - fp32_t
	 */
	public double getZ() {
		return getDouble("z");
	}

	/**
	 *  @return Device Rotation - X (rad) - fp32_t
	 */
	public double getPhi() {
		return getDouble("phi");
	}

	/**
	 *  @return Device Rotation - Y (rad) - fp32_t
	 */
	public double getTheta() {
		return getDouble("theta");
	}

	/**
	 *  @return Device Rotation - Z (rad) - fp32_t
	 */
	public double getPsi() {
		return getDouble("psi");
	}

	/**
	 *  @param x Device Position - X (m)
	 */
	public void setX(double x) {
		values.put("x", x);
	}

	/**
	 *  @param y Device Position - Y (m)
	 */
	public void setY(double y) {
		values.put("y", y);
	}

	/**
	 *  @param z Device Position - Z (m)
	 */
	public void setZ(double z) {
		values.put("z", z);
	}

	/**
	 *  @param phi Device Rotation - X (rad)
	 */
	public void setPhi(double phi) {
		values.put("phi", phi);
	}

	/**
	 *  @param theta Device Rotation - Y (rad)
	 */
	public void setTheta(double theta) {
		values.put("theta", theta);
	}

	/**
	 *  @param psi Device Rotation - Z (rad)
	 */
	public void setPsi(double psi) {
		values.put("psi", psi);
	}

}
