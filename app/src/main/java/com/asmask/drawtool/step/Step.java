package com.asmask.drawtool.step;

import com.asmask.drawtool.DrawMainActivity;
import com.asmask.drawtool.bean.Pel;
import com.asmask.drawtool.widget.CanvasView;


/**
 * 步骤类
 */
public abstract class Step {
    /**
     * 通知重绘用
     */
    public static CanvasView canvasVi = DrawMainActivity.getCanvasView();
    /**
     * 最早放入undo的图元
     */
    public Pel curPel;

    public Step(Pel pel)
    {
        this.curPel = pel;
    }

    /**
     * 进undo栈时对List中图元的更新（子类覆写）
     */
    public abstract void toUndoUpdate();

    /**
     * 进redo栈时对List中图元的反悔（子类覆写）
     */
    public abstract void toRedoUpdate();

    /**
     * 进undo栈时对List中图元的更新（子类覆写）
     * @param pel
     */
    public abstract void setToUndoPel(Pel pel);
}
