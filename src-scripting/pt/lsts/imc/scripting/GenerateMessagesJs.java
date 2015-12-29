/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2016, Laboratório de Sistemas e Tecnologia Subaquática
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
 * $Id:: GenerateMessagesJs.java 333 2013-01-02 11:11:44Z zepinto              $:
 */
package pt.lsts.imc.scripting;

import java.util.Collections;
import java.util.Vector;

import pt.lsts.imc.IMCDefinition;
import pt.lsts.imc.IMCMessageType;

public class GenerateMessagesJs {

    public static void main(String[] args) {

        String code = "";
        System.out.println("/*\nThis code is automatically generated by " + GenerateMessagesJs.class.getName() + "\n");
        Vector<String> msgNames = new Vector<String>();
        msgNames.addAll(IMCDefinition.getInstance().getMessageNames());
        Collections.sort(msgNames);
        System.out.println("*/\n");

        for (String msg : msgNames) {

            code += "function " + msg + "(";
            IMCMessageType type = IMCDefinition.getInstance().getType(msg);

            for (String f : type.getFieldNames()) {
                code += f + ", ";
            }
            if (!type.getFieldNames().isEmpty())
                code = code.substring(0, code.length() - 2);
            code += ") {\n\tm = new Message('" + msg + "');\n";

            for (String f : type.getFieldNames()) {
                code += "\tif (" + f + ") m." + f + " = " + f + "; //" + type.getFieldType(f) + "\n";
            }

            code += "\treturn m;\n}\n\n";
        }

        System.out.println(code);
    }

}
