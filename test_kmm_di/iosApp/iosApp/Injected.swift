//
//  Injected.swift
//  iosApp
//
//  Created by Anna Zharkova on 02.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

@propertyWrapper
struct Injected<T:AnyObject> {
    private var service: T?
    public  var container = KoinDIFabric.companion.instance
    
    public init(){}
    
    public var wrappedValue: T? {
        mutating get {
            if self.service == nil {
                self.service = container.resolve(type: T.self) as? T
            }
            return service
        }
        mutating set { service = newValue  }
    }
    public var projectedValue: Injected<T> {
        get { return self }
        mutating set { self = newValue }
    }
}
