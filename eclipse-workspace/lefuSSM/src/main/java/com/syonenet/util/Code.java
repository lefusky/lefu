package com.syonenet.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * �õ���֤��
 * 
 * @author Administrator
 * 
 */
public class Code {

	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		try {
			Date date = simpleDateFormat.parse("2017-08-08 00:00:00");
			System.out.println(date.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ���ڻ�ȡ��λ�����
	private char mapTable[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	// ������֤��,������������ɵ�����
	public String getEnsure(int width, int height, OutputStream os) {
		if (width <= 0)
			width = 80;
		if (height <= 0)
			height = 42;

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ��ȡͼ��������
		Graphics g = image.getGraphics();

		// �趨����ɫ
		g.setColor(new Color(0xDCCCCC));
		g.fillRect(0, 0, width, height);

		// ���߿�
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);

		// ȡ�����������֤��
		String strEnsure = "";

		// 4����4λ��֤��
		for (int i = 0; i < 4; ++i) {
			strEnsure += mapTable[(int) (mapTable.length * Math.random())];
		}

		// ����֤����ʾ��ͼ����
		g.setColor(Color.red);
		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));

		// ���ľ�������
		String str = strEnsure.substring(0, 1);
		g.drawString(str, 15, 24);
		str = strEnsure.substring(1, 2);
		g.drawString(str, 30, 25);
		str = strEnsure.substring(2, 3);
		g.drawString(str, 45, 28);
		str = strEnsure.substring(3, 4);
		g.drawString(str, 60, 25);

		// �ͷ�ͼ��������
		g.dispose();

		try {
			// ���ͼ��ҳ��
			ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
			return "";
		}

		// �������ɵ������
		return strEnsure;
	}

}
