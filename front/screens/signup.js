// SignUp.js
import React from 'react'
import {
  View,
  Button,
  TextInput,
  StyleSheet,
  Text
} from 'react-native'

export default class SignUp extends React.Component {
  state = {
    username: '', password: '', email: '', phone_number: ''
  }
  onChangeText = (key, val) => {
    this.setState({ [key]: val })
  }
  signUp = async () => {
    const { username, password, email, phone_number } = this.state
    try {
        fetch('http://192.168.1.23:8080/registerUser', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(
                {
                    "username":username,
                    "password":password,
                    "email":email
                }
            ),
            }); 
        console.log('user successfully signed up!: ', success)
    } catch (err) {
        console.log('error signing up: ', err)
    }
  }
 
  render() {
    return (

        
      <View style={styles.container}>
          <Text style = {{fontSize:18, color:'#42A5F5', fontFamily:''}}>WELCOME TO ARIBA URL SHORTENER {"\n"}{"\n"}{"\n"}{"\n"}</Text>
        <TextInput
          style={styles.input}
          placeholder='Username'
          autoCapitalize="none"
          placeholderTextColor='white'
          onChangeText={val => this.onChangeText('username', val)}
        />
        <TextInput
          style={styles.input}
          placeholder='Password'
          secureTextEntry={true}
          autoCapitalize="none"
          placeholderTextColor='white'
          onChangeText={val => this.onChangeText('password', val)}
        />
        <TextInput
          style={styles.input}
          placeholder='Email'
          autoCapitalize="none"
          placeholderTextColor='white'
          onChangeText={val => this.onChangeText('email', val)}
        />
        <Button
          title='Sign Up'
          onPress={this.signUp}
        />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  input: {
    width: 350,
    height: 55,
    backgroundColor: '#42A5F5',
    margin: 10,
    padding: 8,
    color: 'white',
    borderRadius: 14,
    fontSize: 18,
    fontWeight: '500',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  }
})