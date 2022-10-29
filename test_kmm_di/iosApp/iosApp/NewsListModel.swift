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
    
    private lazy var presenter: INewsPresenter = {
        let presenter = NewsPresenter()
        presenter.attach(view: self)
        return presenter
    }()
    
    func loadNews() {
        self.presenter.loadNews()
    }
    
    func setupData(data: NewsList) {
        self.items = data.articles ?? [NewsItem]()
    }
}
