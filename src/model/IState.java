package model;

import controller.action_framework.IAction;

public interface IState {

	public abstract void apply(IAction action);
}
