/*
 * Copyright (c) 2005, romain guy (romain.guy@jext.org) and craig wickesser (craig@codecraig.com)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package net.java.swingfx.jdraggable.demo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.java.swingfx.jdraggable.Draggable;

/**
 * A {@link javax.swing.JLabel} which implements the
 * {@link net.java.swingfx.jdraggable.Draggable} interface
 * 
 * @author craig
 * @since v0.1 <br>
 *        $Header:
 *        /cvs/swingfx/src/net/java/swingfx/jdraggable/demo/DraggableLabel.java,v
 *        1.1 2005/02/26 22:55:45 codecraig Exp $
 */
public class DraggableLabel extends JLabel implements Draggable {
    private static final long serialVersionUID = 3544671789059028281L;

    public DraggableLabel(String text) {
        super(text);
        setBorder(new TitledBorder(new LineBorder(Color.RED), "JLabel"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.codecraig.jdraggable.Draggable#getComponent()
     */
    public Component getComponent() {
        return this;
    }
}