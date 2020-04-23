import React from 'react';
import {StyleSheet, View, Text, Button} from 'react-native';

export default function Home({navigation}) {

    const pressHandlerRegister = () => 
    {
        navigation.navigate('Signup')
    }

    const pressHandlerSignin = () => 
    {
        navigation.navigate('Login')
    }
    return(
        <View>
            <Text>Home screen</Text>
            <Text>Welcome to Ariba URL shortener</Text>

            <Text>{"\n"}</Text>
            <Button title='Register' onPress={pressHandlerRegister} />

            <Text>{"\n"}</Text>
            <Button title='Sign in' onPress={pressHandlerSignin} />
        </View>
    )
}
