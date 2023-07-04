package com.asmask.drawtool.step;


import com.asmask.drawtool.bean.Pel;
import com.asmask.drawtool.widget.CanvasView;

/**
 * 删除图元步骤
 */
public class DeletePelStep extends DrawpelStep
{
	public DeletePelStep(Pel pel)
	{
		super(pel);
	}
	
	@Override
	public void toUndoUpdate() //覆写
	{
		CanvasView.getPelList().remove(location); //删除链表对应索引位置图元
		canvasVi.updateSavedBitmap();
	}
	
	@Override
	public void toRedoUpdate() //覆写
	{
		CanvasView.getPelList().add(location,curPel); //更新图元链表数据
		canvasVi.updateSavedBitmap();
	}
}
