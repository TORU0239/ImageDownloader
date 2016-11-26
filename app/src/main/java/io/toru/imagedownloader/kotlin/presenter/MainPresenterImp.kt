package io.toru.imagedownloader.kotlin.presenter

import io.toru.imagedownloader.kotlin.view.MainView

/**
 * Created by wonyoung on 2016. 11. 27..
 */
class MainPresenterImp(var main : MainView) : MainPresenter {

    override fun onInitMainView() {
        main.initView()
    }

    override fun onPresentMainModel() {
        main.updateView()
    }
}