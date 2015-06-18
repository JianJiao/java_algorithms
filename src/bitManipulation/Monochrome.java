package bitManipulation;

public class Monochrome{


	/**
	*	@note: (@update: changed this)if x1, x2 in the same byte, this implementation is wrong, 
	*	since it simply assign the byte. 
	*	@assume: x1, x2 starts from 0;
	*	@note: problematic: should not clear the previous diagram, should draw on top of that.
	*	So should mask, not assign to start and end byte
	*/
	public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
		if(x1 < 0 || x1 > w - 1 || x2 < 0 || x2 > w - 1){
			throw new IllegalArgumentException("x index exceed limit");
		}
		if(x1 > x2){
			throw new IllegalArgumentException("x1 should not be greater than x2");
		}

		int h = screen.length * 8 / w;
		int realY = h - y - 1;
		int startByte = (w / 8) * realY + x1 / 8;
		int endByte = (w / 8) * realY + x2 / 8;
		if(startByte - endByte > 1){
			for(int i = startByte; i < endByte; i++){
				screen[i] = 0xFF;
			}
		}
		int x1InCell = x1 % 8;
		int x2InCell = x2 % 8;
		int bitCount1 = 8 - x1InCell;
		int bitCount2 = 8 - x2InCell;
		// @better: you could just shift 0xFF, this is faster
		byte start = (1 << bitCount1) -1;
		byte end = 0xFF - ((1 << (bitCount2 - 1)) - 1);
		// @note: @changeif in the same byte:
		if(startByte == endByte){
			// @note: also here, should not assign
			screen[startByte] |= start & end;
		}else{
			// @note: @change: should not directly assign, because you don't want to clear the
			// previous lines, you just draw on top of that
			screen[startByte] |= start;
			screen[endByte] |= end;
		}
	}
}