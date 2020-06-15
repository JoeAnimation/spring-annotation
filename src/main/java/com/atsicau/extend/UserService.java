package com.atsicau.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@EventListener(classes = {ApplicationEvent.class})
	public void listener(ApplicationEvent applicationEvent){
		System.out.println("UserService....监听到的事件:"+applicationEvent);
	}
}
