import SwiftUI
import shared

@main
struct iOSApp: App {
    let koinDI = KoinDIFabric.companion.instance
    
	var body: some Scene {
		WindowGroup {
            NewsListView()
        }
	}
}
