package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public interface ISelectable {
	public void setSelected(boolean select);
	public boolean isSelected();
	public boolean contains(Point pPtr, Point pCmp);
	public void draw(Graphics g, Point pCmpRelPrnt);

}
