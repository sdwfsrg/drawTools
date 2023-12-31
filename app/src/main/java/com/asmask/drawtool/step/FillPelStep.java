package com.asmask.drawtool.step;

import android.graphics.Paint;

import com.asmask.drawtool.bean.Pel;


/**
 * 填充图元步骤
 */
public class FillPelStep extends Step
{
	private Paint oldPaint,newPaint;
	
	public FillPelStep(Pel pel, Paint oldPaint, Paint newPaint)
	{
		super(pel);
		this.oldPaint=new Paint(oldPaint);
		this.newPaint=new Paint(newPaint);
	}
	
	@Override
	public void toUndoUpdate() //覆写
	{
		(curPel.paint).set(newPaint);
		canvasVi.updateSavedBitmap();
	}
	
	@Override
	public void toRedoUpdate() //覆写
	{
		(curPel.paint).set(oldPaint);
		canvasVi.updateSavedBitmap();
	}

	@Override
	public void setToUndoPel(Pel pel) {

	}
}
