//
//  NewsListModel.swift
//  iosApp
//
//  Created by Anna Zharkova on 03.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

class NewsListModel : ObservableObject, INewsView {

    
    @Published var items: [NewsItem] = [NewsItem]()
   //@Injected var presenter: NewsPresenter?
    @ProvidePresenter var presenter: NewsPresenter?
    
    init() {
        $presenter.view = self
    }
    
    /*
    private lazy var presenter: INewsPresenter? = {
        let presenter = //KoinDIFabric.companion.instance.resolve(type: NewsPresenter.self) as? NewsPresenter //
        ConfigFactory.companion.shared.createPresenter(view: self) as? INewsPresenter
           presenter?.attach(view: self)
           return presenter
       }()*/
    
    /*private lazy var presenter: INewsPresenter? = {
        let presenter = ConfigFactory.shared.createPresenter(view: self) as? INewsPresenter
           presenter?.attach(view: self)
           return presenter
       }()*/
    
/*  private lazy var presenter: INewsPresenter? = {
      let presenter = DIFabric.shared.resolveDirect() as? NewsPresenter
        presenter?.attach(view: self)
        return presenter
    }()*/
    
    func loadNews() {
        self.presenter?.attach(view: self)
      self.presenter?.loadNews()
    }
    
    func setupData(data: NewsList) {
        self.items = data.articles ?? [NewsItem]()
    }
}
