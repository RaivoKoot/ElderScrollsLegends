package model;

import controller.actions.IAction;

public interface IState {

	public abstract void apply(IAction action);
}
