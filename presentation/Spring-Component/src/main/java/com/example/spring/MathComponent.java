package com.example.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("math")
@Service
public class MathComponent {

	public int add(int x, int y) {
		return x + y;
	}
}
