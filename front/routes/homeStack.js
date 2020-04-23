import {createStackNavigator} from 'react-navigation-stack';
import {createAppContainer} from 'react-navigation';
import Home from '../screens/home';
import SignUp from '../screens/signup';
import Login from '../screens/login';
import Linkoptions from '../screens/linkoptions';
import ShortLinkPage from '../screens/shortlinkpage';

 

const screens = {


    Home: {
        screen: Home
    },
    Signup: {
        screen: SignUp
    },
    Login: {
        screen: Login
    },
    LinkOptions: {
        screen: Linkoptions
    },
    ShortLink: {
        screen: ShortLinkPage
    }

}

const HomeStack = createStackNavigator(screens)

export default createAppContainer(HomeStack);