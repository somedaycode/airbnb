//
//  CurationModel.swift
//  swift-airbnb
//
//  Created by user on 2021/05/20.
//

import Foundation

class CurationModel {
    private(set) var curationImage: String
    
    init(curationImage: String) {
        self.curationImage = curationImage
    }
}

extension CurationModel: Hashable, Equatable {
    static func == (lhs: CurationModel, rhs: CurationModel) -> Bool {
        return lhs.curationImage == rhs.curationImage
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(curationImage)
    }
}
