/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final int RADIUS_OUTER_CIRCLE = 72;
	
	private static final double RADIUS_WHITE_CIRCLE = 0.65*72;
	
	private static final double RADIUS_INNER_CIRCLE = 0.3*72;
	
	public void run() {
		GOval OuterOval = new GOval (RADIUS_OUTER_CIRCLE,RADIUS_OUTER_CIRCLE);
		OuterOval.setLocation(300,200);
		OuterOval.setFilled(true);
		OuterOval.setFillColor(Color.RED);
		OuterOval.setColor(Color.RED);
		add(OuterOval);
		GOval WhiteOval = new GOval (RADIUS_WHITE_CIRCLE,RADIUS_WHITE_CIRCLE);
		WhiteOval.setLocation(300+0.5*(RADIUS_OUTER_CIRCLE-RADIUS_WHITE_CIRCLE),200+0.5*(RADIUS_OUTER_CIRCLE-RADIUS_WHITE_CIRCLE));
		WhiteOval.setFilled(true);
		WhiteOval.setFillColor(Color.WHITE);
		add(WhiteOval);
		GOval InnerOval = new GOval (RADIUS_INNER_CIRCLE,RADIUS_INNER_CIRCLE);
		InnerOval.setLocation(300+0.5*(RADIUS_OUTER_CIRCLE-RADIUS_INNER_CIRCLE),200+0.5*(RADIUS_OUTER_CIRCLE-RADIUS_INNER_CIRCLE));
		InnerOval.setFilled(true);
		InnerOval.setFillColor(Color.RED);
		add(InnerOval);
	}
}
